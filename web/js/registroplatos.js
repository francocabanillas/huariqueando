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
    

    document.getElementById("descargarCodigo").text='Generar QR';

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
                                '   <th> <a type="button" id="'+plato.id+'" value="'+plato.id+'" href="#" > editar</a> - <a type="button" id="'+plato.id+'" value="'+plato.id+'" href="#" > eliminar </a> </th>'+
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
        combosave();
        // console.log(data);
        if (data.validado){
          document.getElementById("estado").value="Activo";
        }else{
          document.getElementById("estado").value="Por validar";       

        }
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
     url:'http://localhost:8080/api/distritos',
     success: function(data){
       $.each(data, function(i, distrito){
           $distritos.append('<option value="'+distrito.id+'" >'+ distrito.nombre +  '</option>');
       });
       
       
     }
     ,error: function(xhr, status, error) {
        var err = eval("(" + xhr.responseText + ")");
        alert(err.Message);
      }
    }
    );







});
function eliminarplato(){
  
}

function eliminarplato(){
  
}

function validarplato() {
  if (document.getElementById("nombreplato").value == ''){
      alert("Ingrese el nombre del plato");
      return true;
  }
  if (document.getElementById("precioplato").value == ''){
    alert("Ingrese el precio del plato");
    return true;
  }
  if (document.getElementById("estado").value == 'Por validar'){
    alert("Valide su restaurante antes de crear platos");
    return true;
}

// if (comboSet("distrito_idsave").length=0){
//     alert("Actualice un distrito");
//     return true;
// }
  return false;
};

function comboselect(){
  var combo=document.getElementById("distritos");
  setCookie("distrito_id",combo.options[combo.selectedIndex].value);  
}
function combosave(){
  var combo=document.getElementById("distritos");
  setCookie("distrito_idsave",combo.options[combo.selectedIndex].value);  
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
  if (validarplato()){
    return;
  }

   var id = document.getElementById("idusuario").value;
  //  var combo=document.getElementById("distritos");
  // var distrito = combo.options[combo.selectedIndex].value;
   var plato = JSON.stringify({"nombre": $("#nombreplato").val(), 
   "precio": $("#precioplato").val(), 
   "distrito_id": 1,//getCookie("distrito_idsave"), 
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
                location.reload();
                document.getElementById("nombreplato").value='';
                document.getElementById("precioplato").value='';
                document.getElementById("etiquetaplato").value='';
                
             },error: function(xhr, status, error) {
                alert("Falta registrar datos");
              }
   });
}

function validarrestaurante() {
  if (document.getElementById("token").value == ''){
      alert("Ingrese código de verificacion");
      return true;
  }

  var combo=document.getElementById("distritos");
  if (combo.selectedIndex == -1){
      alert("Seleccione distrito");
      return true;
  }

};

function actualizarcliente ()
{

  if (validarrestaurante()){
    return;
  }


  var id = document.getElementById("idusuario").value;

   var combo=document.getElementById("distritos");
   var distrito = combo.options[combo.selectedIndex].value;
   var restaurante = JSON.stringify({"direccion": document.getElementById("direccion").value, 
   "identificacion": document.getElementById("dni").value, 
   "nombre": document.getElementById("apellido").value, 
   "telefono": document.getElementById("telefono").value,
   "distrito_id": distrito,
   "token": document.getElementById("token").value});
//    {
//     "direccion": "Calle Lorenzo 1661",
//     "identificacion": 15161151,
//     "nombre": "ronald1232",
//     "telefono": "1511",
//     "distrito_id": 1,
//     "token":""
// }
   console.log(restaurante);
   $.ajax({
               headers: {  
                  'Accept': 'application/json',
                  'Content-Type': 'application/json' 
            }, 
            type: "PUT",
             dataType: "json",
             url:'http://localhost:8080/api/restaurante/actualizar/'+id,             
             data: restaurante,
             success: function (data) {
                console.log(data);
                combosave();
                alert("Datos guardados");                
             },error: function(xhr, status, error) {
                alert("Error");
              }
   });
}

function imprimirqr(){
  var div = document.getElementById('codigoQR');
  
  
  var miCodigoQR = new QRCode("codigoQR");  
  var id = document.getElementById("idusuario").value;
  miCodigoQR.clear;
  
  miCodigoQR.makeCode(id);
  document.getElementById("descargarCodigo").text='Descargar QR';
  var base64 = $("#codigoQR img").attr('src');
  $("#descargarCodigo").attr('href', base64);
  $("#descargarCodigo").attr('download', "codigoQR");
}