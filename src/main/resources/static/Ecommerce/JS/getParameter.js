jQuery(document).ready(function () {
    $.ajax({
        method: "GET",
        url: "http://localhost:8080/cadastros/parameter/" + 2, // Concatenando o valor de id à URL
        success: function (response) {
            console.log(response);
            $("#tituloHome").text(response.tituloHome);
            $("#colecoes").text(response.colecoes);
            $("#footer").text(response.footer);
            $("#subTitle").text(response.subTitle);
        },
    }).fail(function (xhr, status, errorThrown) {
        alert("Erro ao Buscar Parametro por id: " + xhr.responseText);
    });
});
  //	if (localStorage.getItem("user")) {
  //	document.getElementById("cadastroTop").style.display = "none";
  //	document.getElementById("loginTop").style.display = "none";
  //	$("#nameUser").text("Olá, " + localStorage.getItem("user"));
  //	} else {
  //	document.getElementById("cadastroTop").style.display = "block";
  //	document.getElementById("loginTop").style.display = "block";
  //	$("#nameUser").text(" ") ;
  //	}

