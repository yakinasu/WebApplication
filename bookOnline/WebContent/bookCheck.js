/**
 *
 */
 function checkBlank(){
    		var flag = 0;
			window.alert('必須項目に未入力がありました');
    		if (document.checkBlank.tytle.value == "") {
    			flag = 1;
    		}
		if (flag) {
			window.alert('必須項目に未入力がありました');
			return false;
		} else {
			return true;
		}
    }