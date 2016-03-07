function showNavList(){
	var list = document.getElementsByClassName('nav-item-list');
	var navItem = document.getElementsByClassName('nav-item');
console.log(typeof(list[0]));
console.log(typeof(navItem[0]));
	for(var i=0;i<navItem.length;i++){
		navItem[i].onmousehover = function(){
			list[i].style.display = 'block';

		};
	}
}

function rememberPasswordIcon(){
	var flag = true;
	var remember = document.getElementById('remember');
	var rememberIcon = document.getElementById('icon-remember');
	remember.onclick = function(){
		if(flag){
			rememberIcon.className = 'icon-check icon';
			flag = false;
		}else{
			rememberIcon.className = 'icon-check-empty icon';
			flag = true;
		}
		
	}
}



onload = function(){
	showNavList();
	rememberPasswordIcon();
}