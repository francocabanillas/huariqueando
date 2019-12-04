$(function(){

    var $distritos = $('#distritos');
    var $platos = $('#platos');
    
    var $idusuario = $('#idusuario');
    var $nombre = $('#nombre');
    var $apellido = $('#apellido');
    var $dni = $('#dni');
    var $correo = $('#correo');
    var $direccion = $('#direccion');
    var $telefono = $('#telefono');

    var id = getCookie("idusuario");

    if (document.getElementById("idusuario").value != ''){
      id = document.getElementById("idusuario").value;
    }

    $.ajax({
        type: 'GET',
        dataType: "json",
        url:'http://localhost:8080/api/restaurante/platos/'+id,
        success: function(data){
          var conteo = 0;

          $.each(data, function(i, plato){
              conteo=conteo+1;
              $platos.append('<tr value='+plato.id+'>    '+
                                '   <th>'+conteo+'</th>'+
                                '   <th>'+plato.nombre+'</th>'+
                                '   <th>'+plato.etiqueta+'</th>'+
                                '   <th>'+plato.precio+'</th>'+
                                '   <th>'+plato.puntuacion+'</th>'+
                             '</tr>');
          });
          
        }
        ,error: function(xhr, status, error) {
           var err = eval("(" + xhr.responseText + ")");
           alert(err.Message);
         }
       }
    );

    

    $.ajax({
      type: 'GET',
      dataType: "json",
      url:'http://localhost:8080/api/restaurante/'+id,
      success: function(data){
        document.getElementById("idusuario").value=data.id;
        document.getElementById("nombre").value=data.usuario;
        document.getElementById("apellido").value=data.nombre;
        document.getElementById("dni").value=data.identificacion;
        document.getElementById("correo").value=data.correo;
        document.getElementById("direccion").value=data.direccion;
        document.getElementById("telefono").value=data.telefono;
        setCookie("distrito_id",data.distrito_id);
      }
      ,error: function(xhr, status, error) {
         var err = eval("(" + xhr.responseText + ")");
         alert(err.Message);
       }
     }
  );

    $distritos.append('<option>seleccione</option>');
    $.ajax({
     type: 'GET',
     dataType: "json",
     url:'http://localhost:8080/api/distritos',
     success: function(data){
       $.each(data, function(i, distrito){
           $distritos.append('<option value="'+distrito.id+'" >'+ distrito.nombre +  '</option>');
       });
       comboSet();
       
     }
     ,error: function(xhr, status, error) {
        var err = eval("(" + xhr.responseText + ")");
        alert(err.Message);
      }
    }
    );







});
function comboselect(){
  var combo=document.getElementById("distritos");
  setCookie("distrito_id",combo.options[combo.selectedIndex].value);  
}

function comboSet(){
  var combo=document.getElementById("distritos");
  document.getElementById('distritos').value=getCookie("distrito_id");
}


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

function registrarplato()
{
   var id = document.getElementById("idusuario").value;
   var combo=document.getElementById("distritos");
   var distrito = combo.options[combo.selectedIndex].value;
   var plato = JSON.stringify({"nombre": $("#nombreplato").val(), 
   "precio": $("#precioplato").val(), 
   "distrito_id": distrito, 
   "etiqueta": $("#etiquetaplato").val(),
   "puntuacion": 0});
   $.ajax({
               headers: {  
                  'Accept': 'application/json',
                  'Content-Type': 'application/json' 
            }, 
            type: "POST",
             dataType: "json",
             url:'http://localhost:8080/api/platoregistro/'+id,             
             data: plato,
             success: function (data) {
                alert("Plato registrado");
                $("#nombreplato").val()='';
                $("#precioplato").val()='';
                $("#etiquetaplato").val()='';
             },error: function(xhr, status, error) {
                alert(error);
              }
   });
}