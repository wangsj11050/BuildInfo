
package org.tinygroup.buildinfo.action.exception;

import org.tinygroup.exception.BaseRuntimeException;

/**
 *
 */
public class BusiException extends BaseRuntimeException{

	private static final long serialVersionUID = 1L;

	public BusiException(String errorCode,String errorMsg){
		super(errorCode, errorMsg);
	}
}