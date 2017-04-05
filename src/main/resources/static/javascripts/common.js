/**
 * 公用方法区
 */

/**
 * 公用失败提示弹出方法
 * @param msg  提示信息
 */
function alertFail(msg) {
	$.alert({
		title:'',
		content:msg,
		autoClose: '确定|3000',
		type:'red',
		animation: 'bottom',
		boxWidth: '300px',
	    useBootstrap: false,
	})
}


/**
 * 公用成功信息弹出框
 * @param msg
 * @returns
 */
function alertSuccess(msg,callback) {
	$.alert({
	    title: '',
	    content: msg,
	 	autoClose: '确定|3000',
	    boxWidth: '300px',
	    type:'green',
	 	animation: 'rotate',
	 	typeAnimated: true,
	    useBootstrap: false,
	    buttons:{
	    	确定:()=>{
	    		if(callback!=undefined){
	    			callback();
	    		}
	    	}
	    }
	});
}

