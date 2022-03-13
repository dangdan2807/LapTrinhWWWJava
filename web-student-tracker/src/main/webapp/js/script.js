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