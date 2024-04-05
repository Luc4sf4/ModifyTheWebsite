function saveUser() {

    var name = $("#name").val();
    var email = $("#email").val();
    var password = $("#password").val();
    var password2 = $("#password2").val();

    if (password2 == password) {
        $.ajax(
            {
                method: "POST",
                url: "http://localhost:8080/users/save  ",
                data: JSON.stringify({
                    nome: name,
                    email: email,
                    password: password,
                }),
                contentType: "application/json; charset= utf-8",
                success: function (response) {
                    console.log(response);
                    localStorage.setItem("user", response.name);
                    localStorage.setItem("idUser", response.id);
                    localStorage.setItem("admin", null);
                    window.location.href = "http://localhost:8080/Ecommerce/index.html";
                }

            }).fail(function (xhr, status, errorThrown) {
                alert("Erro ao salvar " + xhr.responseText);
            });
    } else {
        alert("As senhas não são iguais ");
    }
}