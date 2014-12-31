function Account() {

}

jQuery.extend(Account, {
	addPage : function(obj) {
		var options = {
			title : '账号创建',
			modal : true,
			actuator : obj
		}
		var cpId = $('#cp_id_query').val();
		Dgbox.load(Global.contextPath + "/opn/accountAdd.html?cpId="+cpId, options);
	},
	
	addCheck : function(f) {
		if (f.account.value == '') {
			Dgbox.information('账号不能为空！');
			return false;
		}
		
		if (f.nickName.value == '') {
			Dgbox.information('昵称不能为空！');
			return false;
		}
		
		if (f.password.value != '') {
			Dgbox.information('密码不能为空！');
			return false;
		}
		if (f.passwSecond.value != f.password.value) {
			Dgbox.information('密码确认输入不一致！');
			return false;
		}
		
		if (f.email.value == '') {
			Dgbox.information('Email不能为空！');
			return false;
		}
		
		return true;
	},
	
	editCheck : function(f) {
		if (f.nickName.value == '') {
			Dgbox.information('昵称不能为空！');
			return false;
		}
		
		if (f.password.value != '') {
			if (f.passwSecond.value != f.password.value) {
				Dgbox.information('密码确认输入不一致！');
				return false;
			}
		}
		
		if (f.email.value == '') {
			Dgbox.information('Email不能为空！');
			return false;
		}
		
		return true;
	},
	
	delAccount : function(adminId) {
		Dgbox.confirm('确定要删除吗？', function() {
			var option = {
				type : 'get',
				dataType : 'json',
				url : Global.URI + Global.contextPath + '/opn/delAdmin.action',
				data : {'adminId' : adminId},
				async:false,
				success : function(d) {
					if (d.result == 1) {
						Account.loadTable();
						Dgbox.information('删除成功');
					} else {
						Dgbox.information(d.meg);
					}
				}
			};
			jQuery.ajax(option);
		});
	},
	
	loadTable : function() {
		if (!Global.checkLogin()) {
			return;
		}
		var loadingAjax = jQuery('#loading_ajax_1');
		loadingAjax.empty().append(Global.LOADING);
		loadingAjax.load(Global.contextPath
				+ "/opn/accountTable.html"+window.location.search);
	}
});