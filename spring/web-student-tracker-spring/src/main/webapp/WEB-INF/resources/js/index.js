var url_string = window.location.href;
var url = new URL(url_string);
var param = url.searchParams.get("result");
if (param === 'true')
	document.getElementById('notify-success').classList.remove('d-none');
else if (param === 'false')
	document.getElementById('notify-danger').classList.remove('d-none');