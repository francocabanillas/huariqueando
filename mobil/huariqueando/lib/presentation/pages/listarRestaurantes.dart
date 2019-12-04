import 'package:flutter/material.dart';
import 'package:flutter_rating_bar/flutter_rating_bar.dart';
import 'package:http/http.dart'  as http;
import 'dart:async';
import 'dart:convert';

import 'package:huariqueando/presentation/pages/listarPlatos.dart';



class ListarRestaurantes extends StatefulWidget {
  @override
  _ListarRestaurantesState createState() => _ListarRestaurantesState();
}

class _ListarRestaurantesState extends State<ListarRestaurantes> {

  Future<List> getData() async{
    final response = await http.get("http://10.10.10.183:8080/api/restaurantes");
    return json.decode(response.body);
  }//
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      
      appBar: AppBar(

        title: new Text("Huariques UPC"),
      ),
      

      body: new FutureBuilder<List>(
        future: getData(),
        builder: (context, snapshot){
          if(snapshot.hasError) print(snapshot.error);
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
                onTap: () => Navigator.of(context).push(
                    new MaterialPageRoute(
                      builder: (BuildContext context) => new ListarPlatos(
                        list: list,
                        index: i,
                      )
                    ),
                  ),
           
            child: new Card(
              elevation: 5.0,
              shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(10.0)),

              child: Column(
                  children: <Widget>[ new ListTile(
                  leading: Image.asset('assets/icons/restaurantes.png'),
                  title: new Text(
                    list[i]['nombre'],
                    style: TextStyle(fontSize: 20.0, color: Colors.orangeAccent),
                  ),
                  subtitle: new Text(
                    "Direccion: ${list[i]['direccion']}",
                    style: TextStyle(fontSize: 18.0, color: Colors.black),
                  ),
                  trailing: Icon(Icons.check_circle, color: Colors.lightGreen),
                ),
                Row(
                  mainAxisAlignment: MainAxisAlignment.end,
                  children: <Widget>[ 
                    FlatButton(
                      child:  Text(
                      "Telefono: ${list[i]['telefono']}",
                      style: TextStyle(fontSize: 15.0, color: Colors.black),
                     ),
                      
                    ),
                  ],
                ),
                ],
              ),


          ),
        ),
      );
    },
    );
  }
}