function accesologin()
{

   var credenciales = JSON.stringify({"correo": $("#correo").val(), "clave": $("#clave").val()});
   $.ajax({
               headers: {  
                  'Accept': 'application/json',
                  'Content-Type': 'application/json' 
            }, 
            type: "POST",
             dataType: "json",
             url:'http://localhost:8080/api/restaurante/iniciasesion',             
             data: credenciales,
             success: function (data) {
                setCookie("idusuario",data.id);
                console.log(getCookie("idusuario"));
                location.href="registroplatos.html";
             },error: function(xhr, status, error) {
                alert("Usuario o contraseña incorrecto");
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