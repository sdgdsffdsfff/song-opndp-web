$.ajaxSetup({
	cache : false
});

$.fn.overflow = function(options) {
	options = options || {};
	var defaults = {
		length : 15
	};
	options = jQuery.extend({}, defaults, options);

	$(this).each(
			function() {
				var _self = $(this);
				if (_self.text().length > options.length) {
					if (_self.text().substring(_self.text().length - 3,
							_self.text().length) != '...') {
						_self.attr("title", _self.text());
						var str = jQuery.trim(_self.text()).substring(0,
								options.length);
						_self.text(str + "...");
					}
				}
			});
};

jQuery.extend(Global, {
	LOADING : '<div class="loading"></div>',

	/**
	 * 检查是否登入
	 * 
	 * @return {TypeName}
	 */
	checkLogin : function() {
		var userIdUrl = Global.accountUri + "/userIdOnline.html";
		var options = {
			url : userIdUrl,
			async : false,
			cache : false
		};
		var userObj = jQuery.ajax(options);
		var userId = userObj.responseText;
		if (!userId || userId == 'null' || userId == '') {
			document.location.href = Global.accountUri + '/login.html';
			return false;
		}
		return true;
	},

	showValidateCode : function(img) {
		img.src = Global.contextPath + "/showValidateCode.html?t="
				+ Math.random();
	},

	ajax : function(options) {
		if (!Global.checkLogin()) {
			return;
		}
		jQuery.ajax(options);
	},

	praiseCollor : function(a, collorId, count) {
		var URL = Global.URI + Global.contextPath + '/my/praiseCollor.html';
		var options = {
			type : 'get',
			dataType : 'json',
			url : URL,
			data : {
				'collorId' : collorId,
				'count' : count
			},
			success : function(d) {
				if (d.result == 1) {
					jQuery(a).text('取消赞(' + d.count + ')');
				} else {
					Dgbox.information(d.msg, 1000);
				}
			}
		};
		Global.ajax(options);
	},

	// 取消关注
	cancelFocus : function(o, style, focusId) {
		var URL = Global.URI + Global.contextPath + '/my/cancelFocus.html';
		var options = {
			type : 'get',
			dataType : 'json',
			url : URL,
			data : {
				'style' : style,
				'focusId' : focusId
			},
			success : function(d) {
				if (d.result == 1) {
					$(o).parent().after(d.divTag);
					$(o).parent().remove();
				} else {
					Dgbox.information(d.msg, 1000);
				}
			}
		};
		Global.ajax(options);
	},

	// 关注用户
	followUser : function(o, style, focusId) {
		var URL = Global.URI + Global.contextPath + '/my/followUser.html';
		var options = {
			type : 'get',
			dataType : 'json',
			url : URL,
			data : {
				'style' : style,
				'focusId' : focusId
			},
			success : function(d) {
				if (d.result == 1) {
					$(o).after(d.divTag);
					$(o).remove();
				} else {
					Dgbox.information(d.msg, 1000);
				}
			}
		};
		Global.ajax(options);
	}
});

function toTop() {
	var first_top = $("#mian_body").offset().top;
	move_scoll(first_top);
}

function move_scoll(first_top, speed) {
	if (!speed)
		speed = 500;
	$('html, body').stop();
	$('html, body').animate({
		scrollTop : first_top
	}, speed);
	return false;
}