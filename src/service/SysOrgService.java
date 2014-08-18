package service;

import dao.orm.SysOrg;

public interface SysOrgService {
	
	/**
	 * 插入机构
	 * @param sysOrg
	 * @return
	 */
	SysOrg saveSysOrg(SysOrg sysOrg);
	
	/**
	 * 更新机构
	 * @return
	 */
	SysOrg updateSysOrg(SysOrg sysOrg);
	
	/**
	 * 根据机构ID获取机构信息
	 * @return
	 */
	SysOrg getSysOrg(Integer id);
}
