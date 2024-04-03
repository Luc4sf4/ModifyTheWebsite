jQuery(document).ready(function () {
	var conteudo = '';
	var categoriaRandomica = 4;

	$.ajax({

		method: "GET",
		url: "http://localhost:8080/cadastros/produtos/findAll",
		success: function (response) {
			console.log("Entrou na function");
			for (let i = 0; i < response.length; i++) {
				if (response[i].categoria.idCategoria == Math.floor(Math.random() * categoriaRandomica)) {
					conteudo += '<div class="w3-col s4 "><div class="w3-container"><div class="w3-container"><img src="' + response[i].base64 + '" alt="" class="image"></div>'
						+ response[i].nome +
						'<br><b>'
						+ response[i].preco +
						'</b></div></div>';	

					'</br></b></p></div></div></div></div>';
					console.log(response);
				}

			}
			console.log(response.nome, response.preco, response.base64);

			$("#destaque_list").append("<div class='w3-row'>" + conteudo + '</div>');
		}
	}).fail(function (xhr, status, errorThrown) {
		alert("Erro ao Buscar produtos: " + xhr.reponseText);
	});

});