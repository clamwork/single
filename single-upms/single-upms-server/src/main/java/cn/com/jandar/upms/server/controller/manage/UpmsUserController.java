package cn.com.jandar.upms.server.controller.manage;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import cn.com.jandar.common.base.BaseController;
import cn.com.jandar.common.util.MD5Util;
import cn.com.jandar.common.validator.LengthValidator;
import cn.com.jandar.common.validator.NotNullValidator;
import cn.com.jandar.upms.common.constant.UpmsResult;
import cn.com.jandar.upms.common.constant.UpmsResultConstant;
import cn.com.jandar.upms.dao.model.*;
import cn.com.jandar.upms.api.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 用户controller
 * Created by shuzheng on 2017/2/6.
 */
@Controller
@Api(value = "用户管理", description = "用户管理")
@RequestMapping("/manage/user")
public class UpmsUserController extends BaseController {

    private static Logger _log = LoggerFactory.getLogger(UpmsUserController.class);

    @Autowired
    private UpmsUserService upmsUserService;

    @Autowired
    private UpmsRoleService upmsRoleService;

    @Autowired
    private UpmsOrganizationService upmsOrganizationService;

    @Autowired
    private UpmsUserOrganizationService upmsUserOrganizationService;

    @Autowired
    private UpmsUserRoleService upmsUserRoleService;

    @Autowired
    private UpmsUserPermissionService upmsUserPermissionService;

    @ApiOperation(value = "用户首页")
    @RequiresPermissions("upms:user:read")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "/manage/user/index";
    }

    @ApiOperation(value = "用户组织")
    @RequiresPermissions("upms:user:organization")
    @RequestMapping(value = "/organization/{id}", method = RequestMethod.GET)
    public String organization(@PathVariable("id") int id, ModelMap modelMap) {
        // 所有组织
        List<UpmsOrganization> upmsOrganizations = upmsOrganizationService.selectByExample(new UpmsOrganizationExample());
        // 用户拥有组织
        UpmsUserOrganizationExample upmsUserOrganizationExample = new UpmsUserOrganizationExample();
        upmsUserOrganizationExample.createCriteria()
                .andUserIdEqualTo(id);
        List<UpmsUserOrganization> upmsUserOrganizations = upmsUserOrganizationService.selectByExample(upmsUserOrganizationExample);
        modelMap.put("upmsOrganizations", upmsOrganizations);
        modelMap.put("upmsUserOrganizations", upmsUserOrganizations);
        return "/manage/user/organization";
    }

    @ApiOperation(value = "用户组织")
    @RequiresPermissions("upms:user:organization")
    @RequestMapping(value = "/organization/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object organization(@PathVariable("id") int id, HttpServletRequest request) {
        String[] organizationIds = request.getParameterValues("organizationId");
        // 删除旧记录
        UpmsUserOrganizationExample upmsUserOrganizationExample = new UpmsUserOrganizationExample();
        upmsUserOrganizationExample.createCriteria()
                .andUserIdEqualTo(id);
        upmsUserOrganizationService.deleteByExample(upmsUserOrganizationExample);
        // 增加新记录
        if (null != organizationIds) {
            for (String organizationId : organizationIds) {
                if (StringUtils.isBlank(organizationId)) {
                    continue;
                }
                UpmsUserOrganization upmsUserOrganization = new UpmsUserOrganization();
                upmsUserOrganization.setUserId(id);
                upmsUserOrganization.setOrganizationId(NumberUtils.toInt(organizationId));
                upmsUserOrganizationService.insertSelective(upmsUserOrganization);
            }
        }
        return new UpmsResult(UpmsResultConstant.SUCCESS, "");
    }

    @ApiOperation(value = "用户角色")
    @RequiresPermissions("upms:user:role")
    @RequestMapping(value = "/role/{id}", method = RequestMethod.GET)
    public String role(@PathVariable("id") int id, ModelMap modelMap) {
        // 所有角色
        List<UpmsRole> upmsRoles = upmsRoleService.selectByExample(new UpmsRoleExample());
        // 用户拥有角色
        UpmsUserRoleExample upmsUserRoleExample = new UpmsUserRoleExample();
        upmsUserRoleExample.createCriteria()
                .andUserIdEqualTo(id);
        List<UpmsUserRole> upmsUserRoles = upmsUserRoleService.selectByExample(upmsUserRoleExample);
        modelMap.put("upmsRoles", upmsRoles);
        modelMap.put("upmsUserRoles", upmsUserRoles);
        return "/manage/user/role";
    }

    @ApiOperation(value = "用户角色")
    @RequiresPermissions("upms:user:role")
    @RequestMapping(value = "/role/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object role(@PathVariable("id") int id, HttpServletRequest request) {
        String[] roleIds = request.getParameterValues("roleId");
        // 删除旧记录
        UpmsUserRoleExample upmsUserRoleExample = new UpmsUserRoleExample();
        upmsUserRoleExample.createCriteria()
                .andUserIdEqualTo(id);
        upmsUserRoleService.deleteByExample(upmsUserRoleExample);
        // 增加新记录
        if (null != roleIds) {
            for (String roleId : roleIds) {
                if (StringUtils.isBlank(roleId)) {
                    continue;
                }
                UpmsUserRole upmsUserRole = new UpmsUserRole();
                upmsUserRole.setUserId(id);
                upmsUserRole.setRoleId(NumberUtils.toInt(roleId));
                upmsUserRoleService.insertSelective(upmsUserRole);
            }
        }
        return new UpmsResult(UpmsResultConstant.SUCCESS, "");
    }

    @ApiOperation(value = "用户列表")
    @RequiresPermissions("upms:user:read")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(
            @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "order") String order) {
        UpmsUserExample upmsUserExample = new UpmsUserExample();
        upmsUserExample.setOffset(offset);
        upmsUserExample.setLimit(limit);
        if (!StringUtils.isBlank(sort) && !StringUtils.isBlank(order)) {
            upmsUserExample.setOrderByClause(sort + " " + order);
        }
        List<UpmsUser> rows = upmsUserService.selectByExample(upmsUserExample);
        long total = upmsUserService.countByExample(upmsUserExample);
        Map<String, Object> result = new HashMap<>();
        result.put("rows", rows);
        result.put("total", total);
        return result;
    }

    @ApiOperation(value = "新增用户")
    @RequiresPermissions("upms:user:create")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create() {
        return "/manage/user/create";
    }

    @ApiOperation(value = "新增用户")
    @RequiresPermissions("upms:user:create")
    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Object create(UpmsUser upmsUser) {
        ComplexResult result = FluentValidator.checkAll()
                .on(upmsUser.getUsername(), new LengthValidator(1, 20, "帐号"))
                .on(upmsUser.getPassword(), new LengthValidator(5, 32, "密码"))
                .on(upmsUser.getRealname(), new NotNullValidator("姓名"))
                .doValidate()
                .result(ResultCollectors.toComplex());
        if (!result.isSuccess()) {
            return new UpmsResult(UpmsResultConstant.INVALID_LENGTH, result.getErrors());
        }
        long time = System.currentTimeMillis();
        String salt = UUID.randomUUID().toString().replaceAll("-", "");
        upmsUser.setSalt(salt);
        upmsUser.setPassword(MD5Util.MD5(upmsUser.getPassword() + upmsUser.getSalt()));
        upmsUser.setCtime(time);
        int count = upmsUserService.insertSelective(upmsUser);
        return new UpmsResult(UpmsResultConstant.SUCCESS, count);
    }

    @ApiOperation(value = "删除用户")
    @RequiresPermissions("upms:user:delete")
    @RequestMapping(value = "/delete/{ids}",method = RequestMethod.GET)
    @ResponseBody
    public Object delete(@PathVariable("ids") String ids) {
        int count = upmsUserService.deleteByPrimaryKeys(ids);
        return new UpmsResult(UpmsResultConstant.SUCCESS, count);
    }

    @ApiOperation(value = "修改用户")
    @RequiresPermissions("upms:user:update")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") int id, ModelMap modelMap) {
        UpmsUser user = upmsUserService.selectByPrimaryKey(id);
        modelMap.put("user", user);
        return "/manage/user/update";
    }

    @ApiOperation(value = "修改用户")
    @RequiresPermissions("upms:user:update")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object update(@PathVariable("id") int id, UpmsUser upmsUser) {
        ComplexResult result = FluentValidator.checkAll()
                .on(upmsUser.getUsername(), new LengthValidator(1, 20, "帐号"))
                .on(upmsUser.getRealname(), new NotNullValidator("姓名"))
                .doValidate()
                .result(ResultCollectors.toComplex());
        if (!result.isSuccess()) {
            return new UpmsResult(UpmsResultConstant.INVALID_LENGTH, result.getErrors());
        }
        // 不允许直接改密码
        upmsUser.setPassword(null);
        upmsUser.setUserId(id);
        int count = upmsUserService.updateByPrimaryKeySelective(upmsUser);
        return new UpmsResult(UpmsResultConstant.SUCCESS, count);
    }

}
