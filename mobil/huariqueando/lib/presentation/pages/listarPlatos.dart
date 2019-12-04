import 'dart:convert';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:huariqueando/presentation/pages/calificar.dart';


class ListarPlatos extends StatefulWidget {
  List list;
  int index;
  ListarPlatos({this.index, this.list});

  @override
  _ListarPlatosState createState() => _ListarPlatosState();
}

class _ListarPlatosState extends State<ListarPlatos> {
 
 Future<List> getData() async{
   var codPlato = widget.list[widget.index]['id'];
   final response = await http.get("http://10.10.10.183:8080/api/restaurante/platos/"+codPlato.toString());
   return json.decode(response.body);
 }

 @override
@override
Widget build(BuildContext context) {
  return Scaffold(
    appBar: AppBar(
      title: new Text("Platos ${widget.list[widget.index]['nombre']}"),
    ),
    body: new FutureBuilder<List>(
      future: getData(),
      builder: (context, snapshot){
        if (snapshot.hasError) print(snapshot.error); 
        return snapshot.hasData
        ? new ItemList(
          list: snapshot.data,
        )  
        : new Center(
          child: new CircularProgressIndicator(),
        );
        
      },
    ),
  );
}
  
}

class ItemList extends StatelessWidget {
  final List list;
  ItemList({this.list});

  @override
  Widget build(BuildContext context) {
    return new ListView.builder(
      itemCount: list == null ? 0 : list.length,
      itemBuilder: (context, i){
        return new Container(
          padding: const EdgeInsets.all(10.0),
          child: new GestureDetector(
            child: new Card(
              elevation: 5.0,
              shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(10.0)),
              child: Column(
                children: <Widget>[new ListTile(
                  leading: Image.asset('assets/icons/restaurantes.png'),
                  title: new Text(
                    list[i]['nombre'],
                    style: TextStyle(fontSize: 20.0, color: Colors.orangeAccent),
                  ),
                  subtitle: new Text(
                    "Precio: ${list[i]['precio']}",
                    style: TextStyle(fontSize: 15.0, color: Colors.black),
                  ),
                  trailing: Icon(Icons.check_circle, color: Colors.lightGreen,),
                ),
                Row(
                  mainAxisAlignment: MainAxisAlignment.end,
                  children: <Widget>[
                    FlatButton(
                      child: Text(
                        "Puntuación: ${list[i]['puntuacion']} ",
                        style: TextStyle(fontSize: 14.0, color: Colors.black),
                      ),
                    ),
                    Icon(Icons.star, color: Colors.yellow,),
                    FlatButton(
                      child: Text(
                        'Calificar',
                        style: TextStyle(fontSize: 14.0, color: Colors.blue) ),
                      onPressed: ()=> Navigator.of(context).push(
                    new MaterialPageRoute(
                      builder: (BuildContext context) => new Calificar(
                        list: list,
                        index: i,
                      )
                    ),
                  ),
                    )
                  ],
                )
                ],
              ),
            ),

          ),
        );
      },
    );
  }
}
  
