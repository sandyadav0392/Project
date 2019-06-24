function newImage(arg) {
				if (document.images) {
					rslt = new Image();
					rslt.src = arg;
					return rslt;
				}
			}


function changeImagesArray(array) {
				if (preloadFlag == true) {
					var d = document; var img;
					for (var i=0; i<array.length; i+=2) {
						img = null; var n = array[i];
						if (d.images) {img = d.images[n];}
						if (!img && d.getElementById) {img = d.getElementById(n);}
						if (img) {img.src = array[i+1];}
					}
				}
			}


function changeImages() {
				changeImagesArray(changeImages.arguments);
			}


var preloadFlag = false;
function preloadImages() {
	if (document.images) {
		pre_press_over = newImage('images/navbar-sub/press_over.gif');
		pre_asso_over = newImage('images/navbar-sub/asso_over.gif');
		pre_indirect_over = newImage('images/navbar-sub/indirect_over.gif');
		pre_employment_over = newImage('images/navbar-sub/employment_over.gif');
		pre_contact_over = newImage('images/navbar-sub/contact_over.gif');
		pre_about_over = newImage('images/navbar/about_over.gif');
		pre_why_over = newImage('images/navbar/why_over.gif');
		pre_inbound_over = newImage('images/navbar/inbound_over.gif');
		pre_outbound_over = newImage('images/navbar/outbound_over.gif');
		pre_ebound_over = newImage('images/navbar/ebound_over.gif');
		pre_auto_over = newImage('images/navbar/auto_over.gif');
		pre_fulfillment_over = newImage('images/navbar/fulfillment_over.gif');
		preloadFlag = true;
	}
	
}

