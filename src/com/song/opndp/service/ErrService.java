package com.song.opndp.service;

import com.song.commons.service.ErrorInfo;

/**
 * 异常的业务错误码
 * 
 * @author songzigw
 * 
 */
public abstract class ErrService {
	/**
	 * 通用错误码
	 * 
	 * @author songzigw
	 * 
	 */
	public static enum Common implements ErrorInfo {
		/** 参数不完整异常 */
		ERR_000_001("000_001");

		private final String errCode;

		public String getErrCode() {
			return errCode;
		}

		private Common(String errCode) {
			this.errCode = errCode;
		}

		public Common getInstance(String errCode) {
			for (Common c : Common.values()) {
				if (c.getErrCode().equals(errCode)) {
					return c;
				}
			}
			return null;
		}
	}

	/**
	 * 管理员业务相关错误码
	 * 
	 * @author 张松
	 * 
	 */
	public static enum AdminS implements ErrorInfo {
		/** 账号重复错误码 */
		ERR_100_001("100_001"),
		/** 原始密码错误 */
		ERR_100_002("100_002"),
		/** 关键字异常 */
		ERR_100_003("100_003"),
		/** 昵称重复 */
		ERR_100_004("100_004");

		private final String errCode;

		public String getErrCode() {
			return errCode;
		}

		private AdminS(String errCode) {
			this.errCode = errCode;
		}

		/**
		 * 以枚举值得到枚举类型的实例
		 * 
		 * @param errCode
		 * @return
		 */
		public AdminS getInstance(String errCode) {
			for (AdminS e : AdminS.values()) {
				if (e.getErrCode().equals(errCode)) {
					return e;
				}
			}
			return null;
		}
	}

}