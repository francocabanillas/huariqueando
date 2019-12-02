function accesoLogin()
{
    var credenciales = JSON.stringify({"correo": $("#correo").val(), "clave": $("#clave").val()});
    
     $.ajax({
             type: "GET",
             dataType: "json",
             url:'http://localhost:8080/api/restaurante/iniciasesion',             
             data: credenciales,
             success: function (data) {
                alert(data);
                location.href="registroplatos.html";
             },error: function(xhr, status, error) {
                var err = eval("(" + xhr.responseText + ")");
                alert(err.Message);
              }
    });
};
