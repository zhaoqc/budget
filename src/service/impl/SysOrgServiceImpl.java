package service.impl;

import dao.SysOrgDao;
import dao.orm.SysOrg;
import service.SysOrgService;

public class SysOrgServiceImpl implements SysOrgService{
	private SysOrgDao orgDao;
	@Override
	public SysOrg saveSysOrg(SysOrg sysOrg) {
		orgDao.add(sysOrg);
		return sysOrg;
	}

	@Override
	public SysOrg updateSysOrg(SysOrg sysOrg) {
		orgDao.update(sysOrg);
		return sysOrg;
	}

	@Override
	public SysOrg getSysOrg(Integer id) {
		SysOrg sysOrg = orgDao.get(id);
		return sysOrg;
	}

}
