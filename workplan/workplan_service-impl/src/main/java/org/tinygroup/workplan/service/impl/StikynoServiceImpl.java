package org.tinygroup.workplan.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.tinygroup.buildinfo.common.dict.DictUtil;
import org.tinygroup.buildinfo.common.util.BeanUtil;
import org.tinygroup.workplan.business.inter.StikynoBusiness;
import org.tinygroup.workplan.dao.inter.pojo.TStikyno;
import org.tinygroup.workplan.dto.EventObjectDto;
import org.tinygroup.workplan.dto.StikynoDto;
import org.tinygroup.workplan.service.inter.StikynoService;

public class StikynoServiceImpl implements StikynoService {

	private StikynoBusiness stikynoBusiness;
	private DictUtil dictUtil;
	public StikynoBusiness getStikynoBusiness() {
		return stikynoBusiness;
	}

	public void setStikynoBusiness(StikynoBusiness stikynoBusiness) {
		this.stikynoBusiness = stikynoBusiness;
	}

	public DictUtil getDictUtil() {
		return dictUtil;
	}

	public void setDictUtil(DictUtil dictUtil) {
		this.dictUtil = dictUtil;
	}

	@Override
	public StikynoDto getStikyno(Integer id) {
		// TODO Auto-generated method stub
		return BeanUtil.copyProperties(StikynoDto.class, stikynoBusiness.getStikyno(id));
	}

	@Override
	public StikynoDto addStikyno(StikynoDto stikyno) {
		// TODO Auto-generated method stub
		TStikyno tstikyno = BeanUtil.copyProperties(TStikyno.class, stikyno);
		return BeanUtil.getCopiedPropertiesBean(StikynoDto.class, stikynoBusiness.addStikyno(tstikyno));
	}

	@Override
	public int updateStikyno(StikynoDto stikyno) {
		// TODO Auto-generated method stub
		TStikyno tstikyno = BeanUtil.copyProperties(TStikyno.class, stikyno);
		return stikynoBusiness.updateStikyno(tstikyno);
	}

	@Override
	public List<EventObjectDto> getStikynoList(StikynoDto stikyno) {
		// TODO Auto-generated method stub
		TStikyno tstikyno = BeanUtil.copyProperties(TStikyno.class, stikyno);
		return transFromStikyno(stikynoBusiness.getStikynoList(tstikyno));
	}
	
	//将TStikyno转换为EventObject
	private List<EventObjectDto> transFromStikyno(List<TStikyno> stikynoList){
		List<EventObjectDto> eventObjectList = new ArrayList<EventObjectDto>();
		if(stikynoList != null){
			for (TStikyno tstikyno : stikynoList) {
				EventObjectDto eventObjectDto = new EventObjectDto();
				eventObjectDto.setId(tstikyno.getId());
				eventObjectDto.setTitle(tstikyno.getTilte());
				eventObjectDto.setStart(tstikyno.getHandleTime());
				eventObjectDto.setEnd(tstikyno.getSolveTime());
				eventObjectList.add(eventObjectDto);
			}
		}
		return eventObjectList;
	}

	@Override
	public List<StikynoDto> getStikynoDtoList(StikynoDto stikyno, String order, String orderType) {
		TStikyno tstikyno = BeanUtil.copyProperties(TStikyno.class, stikyno);
		return transFromTStikyno(stikynoBusiness.getIndexStikynoList(tstikyno, order, orderType));
	}

	//将TStikyno转换为StikynoDto
	private List<StikynoDto> transFromTStikyno(List<TStikyno> stikynoList){
		List<StikynoDto> stikynoDtoList = new ArrayList<StikynoDto>();
		if(stikynoList != null){
			for (TStikyno tstikyno : stikynoList) {
				StikynoDto stikynoDto = new StikynoDto();
				stikynoDto.setContent(tstikyno.getContent());
				stikynoDto.setCreateTime(tstikyno.getCreateTime());
				stikynoDto.setCreateUser(tstikyno.getCreateUser());
				stikynoDto.setHandleTime(tstikyno.getHandleTime());
				stikynoDto.setId(tstikyno.getId());
				stikynoDto.setSolveTime(tstikyno.getSolveTime());
				stikynoDto.setTilte(tstikyno.getTilte());
				stikynoDto.setExtField_1(tstikyno.getExtField_1());
				stikynoDto.setExtField_2(dictUtil.getDictItemText("STIKYNO_TYPE", tstikyno.getType().toString()));
				stikynoDto.setExtField_3(dictUtil.getDictItemText("STIKYNO_IS_SOLVE", tstikyno.getExtField_1()));
				stikynoDtoList.add(stikynoDto);
			}
		}
		return stikynoDtoList;
	}
}
