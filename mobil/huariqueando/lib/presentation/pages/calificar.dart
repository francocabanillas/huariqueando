

import 'dart:convert';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_rating_bar/flutter_rating_bar.dart';
import 'package:http/http.dart' as http;
import 'package:http/http.dart';



class Calificar extends StatefulWidget {
  List list;
  int index;
  Calificar({this.index, this.list});

  @override
  _CalificarState createState() => _CalificarState();
}

class _CalificarState extends State<Calificar> {
  var calificaCliente;
 

void registrarPuntuacion(){

   var idCliente = 1;
  var platoid = 1;
  var puntuacionCliente = 3;
  Map<String, String> datos = {
      'id':'null',
      'cliente_id': idCliente.toString(),
	    'plato_id': platoid.toString(),
	    'puntuacion': puntuacionCliente.toString()
};
 
 var data = json.encode(datos);

     var url = 'http://10.10.10.183:8787/api/platopuntaje';
      http.post(url, 
        body: data,
        );

        print(data);
}
   
 
 @override
@override
Widget build(BuildContext context) {
  return Scaffold(
    appBar: AppBar(
      title: new Text("Calificar ${widget.list[widget.index]['nombre']}"),
    ),
    body: Form(
      child: Container(
        decoration: new BoxDecoration(color: Colors.lightGreen),
      child: Column(
        children: <Widget>[
          new ListTile(
            leading: Image.asset("assets/icons/restaurantes.png"),
            title: new Text("${widget.list[widget.index]['nombre']}", 
            style: TextStyle(fontSize: 20.0, color: Colors.black),
            ),
          ),
          RatingBar(
                                  initialRating: 0,
                                  direction: Axis.horizontal,
                                  allowHalfRating: true,
                                  itemCount: 5,
                                  itemPadding: EdgeInsets.symmetric(horizontal: 4.0),
                                  itemBuilder: (context, _) => Icon(
                                    Icons.star,
                                    color: Colors.amber,
                                  ),
                                  onRatingUpdate: (rating) {
                                    print(rating);
                                    calificaCliente = rating;
                                  },
          ),
        new RaisedButton(
            child: new Text("Calificar"),
            color: Colors.orangeAccent,
            shape: new RoundedRectangleBorder(
              borderRadius: new BorderRadius.circular(30.0)
            ),
            onPressed: (){
              registrarPuntuacion();
              Navigator.pop(context);
            },
        )
        ],
      ),
      ),
    ),

  );
}
  
}
