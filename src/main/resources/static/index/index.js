function goToAbout(event){
    let aboutUs = document.getElementById('about');
    aboutUs.scrollIntoView();
}

function see(){
    let input = document.getElementById('password');
if (input.type === 'password'){
    input.type = 'text';
}else {
    input.type = 'password';
}
}