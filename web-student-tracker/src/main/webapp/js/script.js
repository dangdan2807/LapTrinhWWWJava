function imageUrlChanged() {
    var imgAvatar = document.getElementById('img-avatar');
    var imageUrl = document.getElementById('imageUrl');
    var imageUrlLink = imageUrl.value;
    if (imageUrlLink) {
        imgAvatar.hidden = false;
    } else {
        imgAvatar.hidden = true;
    }
    imgAvatar.src = imageUrlLink;
}

function handlerClickRow() {
    console.log("test");
    // var row = event.target.parentNode;
    // var id = row.getAttribute('data-id');
    // var url = '?command=LOAD&studentId=' + id;
    // window.location.href += url;
}
