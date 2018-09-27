package wang.people_list_online.service;

import java.util.List;

import wang.people_list_online.modal.Peoples;

public interface PeopleService {
	/**
	 * 
	 * <h2>������Ա��Ϣ</h2>
	 * <p>�����ݿ������һ����Ա��¼����������ӽ����</p>
	 * @author ������Ұ(kohgylw)
	 * @param iname ������Ա������
	 * @param isex �Ա�
	 * @param iage ����
	 * @return ��SUCCESS������ɹ�����ERROR������ʧ�ܡ�
	 */
	String doInsertPeople(String iname,String isex,Integer iage);
	/**
	 * 
	 * <h2>����������Ա��Ϣ�����б���ʽ����</h2>
	 * <p>�����ݿ�õ�ȫ������Ա��Ϣ������Ϊ�б���ʽ�����û����Ϣ�򷵻�һ�����б�</p>
	 * @author ������Ұ(kohgylw)
	 * @return List<Peoples> ��Ա��Ϣ�б�
	 */
	List<Peoples> getAllPeoples();
	
	/**
	 * 
	 * <h2>ִ��ɾ��ĳһ����Ա��¼</h2>
	 * <p>�����ݿ���ɾ��ָ����ID��Ӧ����Ա��¼��</p>
	 * @author ������Ұ(kohgylw)
	 * @param peoplesId String Ҫɾ������Ա��¼��ID
	 * @return ��SUCCESS������ɾ���ɹ�����ERROR������ɾ��ʧ�ܡ�
	 */
	String doRemovePeople(String peoplesId);
	String getAllPeopleByJson();
}
