package com.xfx.utils;

import java.util.HashMap;
import java.util.Set;

import com.cloopen.rest.sdk.CCPRestSmsSDK;

public class SDKTestSendTemplateSMS {

	
	/**
	 * @param phone Ҫ���͵��ֻ���
	 * @param code Ҫ���͵���֤��
	 * @param time ���ͼ��
	 * @param mode 1������ģʽ ��0������ģʽ
	 */
	public boolean  sendSMS(String phone,String code,String time,String mode){
		HashMap<String, Object> result = null;

		//��ʼ��SDK
		CCPRestSmsSDK restAPI = new CCPRestSmsSDK();
		
		//******************************ע��*********************************************
		//*��ʼ����������ַ�Ͷ˿�                                                       *
		//*ɳ�л���������Ӧ�ÿ������ԣ���restAPI.init("sandboxapp.cloopen.com", "8883");*
		//*�����������û�Ӧ������ʹ�ã���restAPI.init("app.cloopen.com", "8883");       *
		//*******************************************************************************
		if(mode.equals("1")) restAPI.init("sandboxapp.cloopen.com", "8883");
		else if(mode.equals("0")) restAPI.init("app.cloopen.com", "8883");
		//******************************ע��*********************************************
		//*��ʼ�����ʺź����ʺ�����,��Ӧ�������������˺��µ�ACCOUNT SID��AUTH TOKEN     *
		//*ACOUNT SID��AUTH TOKEN�ڵ�½�������ڡ�Ӧ��-�������̨���в鿴���������˺Ż�ȡ*
		//*����˳�򣺵�һ��������ACOUNT SID���ڶ���������AUTH TOKEN��                   *
		//*******************************************************************************
		restAPI.setAccount("aaf98f894d9e9c40014d9f1fbadc00f2", "b16b50cec3544218a425212abdb0a4e4");
		
		
		//******************************ע��*********************************************
		//*��ʼ��Ӧ��ID                                                                 *
		//*���Կ�����ʹ�á�����Demo����APP ID����ʽ������Ҫʹ���Լ�������Ӧ�õ�App ID     *
		//*Ӧ��ID�Ļ�ȡ����½�������ڡ�Ӧ��-Ӧ���б������Ӧ�����ƣ���Ӧ�������ȡAPP ID*
		//*******************************************************************************
		restAPI.setAppId("aaf98f894d9e9c40014d9f21381700ff");//ѧ�������Ӧ��
		
		
		//******************************ע��****************************************************************
		//*���÷���ģ����ŵĽӿڷ��Ͷ���                                                                  *
		//*����˳��˵����                                                                                  *
		//*��һ������:��Ҫ���͵��ֻ����룬�����ö��ŷָ���һ�����֧��100���ֻ���                          *
		//*�ڶ�������:��ģ��ID����ƽ̨�ϴ����Ķ���ģ���IDֵ�����Ե�ʱ�����ʹ��ϵͳ��Ĭ��ģ�壬idΪ1��    *
		//*ϵͳĬ��ģ�������Ϊ������ͨѶ����ʹ�õ�����ͨѶ����ģ�壬������֤����{1}������{2}��������ȷ���롱*
		//*������������Ҫ�滻���������顣																														       *
		//**************************************************************************************************
		
		//**************************************����˵��***********************************************************************
		//*�������ò���Demo��APP ID������ʹ��Ĭ��ģ��ID 1�������ֻ�����13800000000���������Ϊ6532��5������÷�ʽΪ           *
		//*result = restAPI.sendTemplateSMS("13800000000","1" ,new String[]{"6532","5"});																		  *
		//*��13800000000�ֻ����յ��Ķ��������ǣ�����ͨѶ����ʹ�õ�����ͨѶ����ģ�壬������֤����6532������5��������ȷ����     *
		//*********************************************************************************************************************
		result = restAPI.sendTemplateSMS(phone,"1" ,new String[]{code,time});
		
		System.out.println("SDKTestGetSubAccounts result=" + result);
		if("000000".equals(result.get("statusCode"))){
			//�����������data������Ϣ��map��
			HashMap<String,Object> data = (HashMap<String, Object>) result.get("data");
			Set<String> keySet = data.keySet();
			for(String key:keySet){
				Object object = data.get(key);
				System.out.println(key +" = "+object);
			}
			return true;
		}else{
			//�쳣�������������ʹ�����Ϣ
			System.out.println("������=" + result.get("statusCode") +" ������Ϣ= "+result.get("statusMsg"));
			return false;
		}
	}

}
