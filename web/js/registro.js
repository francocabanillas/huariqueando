function validar() {
    if (document.getElementById("nombreusuario").value == ''){
        alert("Ingrese nombre de usuario");
        return true;
    }
    if (document.getElementById("correo").value == ''){
        alert("Ingrese correo");
        return true;
    }
    if (document.getElementById("clave").value == ''){
        alert("Ingrese contraseña");
        return true;
    }
    if (document.getElementById("repetirclave").value  == ''){
        alert("Ingrese repetir la contraseña");
        return true;
    }
    if (document.getElementById("clave").value ==document.getElementById("repetirclave").value)
    {
        return false;
    }
    else{
        alert("clave no coincide");
        return true;
    }
    
};

function registrar()
{
    
    if (validar()){
        return;
    }
   
    // {
    //     "correo":"gerente.general@francochifa.com",
    //     "usuario":"franco",
    //     "clave":"retorno"
    // }


   var credenciales = JSON.stringify({"correo": $("#correo").val(), 
   "usuario": $("#nombreusuario").val(), "clave": $("#clave").val()});

   $.ajax({
               headers: {  
                  'Accept': 'application/json',
                  'Content-Type': 'application/json' 
            }, 
            type: "POST",
             dataType: "json",
             url:'http://localhost:8080/api/restauranteregistro',             
             data: credenciales,
             success: function (data) {
                if (data.estado!='registroExitoso'){
                    switch(data.estado) {
                        case "contraseñaCorta":
                          text = "La contraseña es corta";
                          break;
                        case "existeUsuario":
                          text = "Usuario ya registrado";
                          break;
                        case "existeCorreo":
                          text = "Correo ya registrado";
                          break;
                        case "otrosErrores":
                          text = "Consulte con el administrador";
                          break;
                        default:
                          text = "Consulte con el administrador";
                      } 
                    alert(text);
                    return;
                }
                else
                {
                    setCookie("idusuario",data.restaurante.id);
                    // getCookie("idusuario");
                    location.href="registroplatos.html";
                }                
             },error: function(xhr, status, error) {
                alert(error);
              }
   });
};
function setCookie(name,value) {
   document.cookie = name + ":" + (value || "")  + ";";
}
function getCookie(name) {
   var nameEQ = name + ":";
   var ca = document.cookie.split(';');
   for(var i=0;i < ca.length;i++) {
       var c = ca[i];
       while (c.charAt(0)==' ') c = c.substring(1,c.length);
       if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
   }
   return null;
}