var comment = document.getElementsByTagName('a')[0];
		if (document.all) {
 			// For IE
			comment.click();
		}else if (document.createEvent) {
   			//FOR DOM2
 			var ev = document.createEvent('MouseEvents');
 			ev.initEvent('click', false, true);
 			comment.dispatchEvent(ev);
		}