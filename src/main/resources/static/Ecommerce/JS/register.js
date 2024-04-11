function saveUser() {
  var name = $("#name").val();
  var email = $("#email").val();
  var password = $("#password").val();
  var password2 = $("#password2").val();

  if (password2 == password) {
    $.ajax({
      method: "POST",
      url: "http://localhost:8080/cadastros/users/save  ",
      data: JSON.stringify({
        nome: name,
        email: email,
        password: password,
      }),
      contentType: "application/json; charset= utf-8",
      success: function (response) {
        console.log(response);
        localStorage.setItem("user", response.nome);
        localStorage.setItem("id", response.id);
        localStorage.setItem("admin", null);
        window.location.href = "http://localhost:8080/Ecommerce/index.html";
      },
    }).fail(function (xhr, status, errorThrown) {
      alert("Erro ao salvar " + xhr.responseText);
    });
  } else {
    alert("As senhas não são iguais ");
  }
}
function getUser() {
  var email = $("#emailLogin").val();
  var senha = $("#passwordLogin").val();
  var achou = false;

  $.ajax({
    method: "GET",
    url: "http://localhost:8080/cadastros/users/findAll",
    success: function (response) {
      for (let i = 0; i < response.length; i++) {
        if (response[i].email === email && response[i].password == senha) {
          achou = true;

          localStorage.setItem("user", response[i].nome);
          localStorage.setItem("idUser", response[i].id);
          localStorage.setItem("admin", response[i].admin);

          // se admin ==1   location para o cadastro
          if (response[i].admin == 1) {
            window.location.href =
              "http://localhost:8080/cadastros/produtos.html";
          } else {
            window.location.href = "http://localhost:8080/Ecommerce/index.html";
          }

          break;
        }
      }
      if (!achou) {
        alert("Usuario ou Senha invalido");
      }
    },
  }).fail(function (xhr, status, errorThrown) {
    alert("Erro ao Buscar Usuário" + xhr.reponseText);
  });
}
