package wang.people_list_online.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;

import wang.people_list_online.mapper.PeoplesMapper;
import wang.people_list_online.modal.Peoples;
import wang.people_list_online.service.PeopleService;

@Controller
public class PeopleServiceImpl implements PeopleService {
	private static final String SUCCESS="SUCCESS";
	private static final String ERROR="ERROR";
	@Autowired
	private PeoplesMapper pm;
	@Autowired
	private Gson g;

	public Gson getG() {
		return g;
	}

	public void setG(Gson g) {
		this.g = g;
	}

	public PeoplesMapper getPm() {
		return pm;
	}

	public void setPm(PeoplesMapper pm) {
		this.pm = pm;
	}

	public String doInsertPeople(String iname, String isex, Integer iage) {
		// TODO Auto-generated m
		Peoples ps=new Peoples();
		ps.setPeoplesId(UUID.randomUUID().toString());
		ps.setPeoplesName(iname);
		ps.setPeoplesAge(iage);
		ps.setPeoplesSex(isex);
		try {
			return pm.insert(ps)>0?SUCCESS:ERROR;
		} catch (Exception e) {
			return ERROR;
		}
	}

	public List<Peoples> getAllPeoples() {
		// TODO Auto-generated method stub
		return pm.selectAll();
	}

	public String doRemovePeople(String peoplesId) {
		// TODO Auto-generated method stub
		try {
			return pm.deleteByPrimaryKey(peoplesId)>0?SUCCESS:ERROR;
		} catch (Exception e) {
			// TODO: handle exception
			return ERROR;
		}
	}

	public String getAllPeopleByJson() {
		// TODO �Զ����ɵķ������
		return g.toJson(getAllPeoples());
	}
	}





