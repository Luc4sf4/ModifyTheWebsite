jQuery(document).ready(function() {
	console.log('passou no location')
    const urlParams = new URLSearchParams(window.location.search);
    const nomeUsuario = localStorage.getItem("user");
    const userDiv = $("#nameUser");
    userDiv.text("Olá, " + nomeUsuario);
});