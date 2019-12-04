
import 'package:flutter/material.dart';
import 'package:huariqueando/presentation/pages/listarPlatos.dart';
import 'package:huariqueando/presentation/pages/listarRestaurantes.dart';


class AppBasica extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    // Todas sus apliaciones deben de estar dentro de Material App para poder
    // hacer uso de las facilidades de Material Design puede omitirce esto pero
    // no podran hacer uso de estos widgets de material.dart
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      theme: ThemeData.light(), //  Tema Claro
//      theme: ThemeData.dark(), // Tema Obscuro
      home: ListarRestaurantes(),
      routes: <String, WidgetBuilder>{
          '/presentation/pages/listarRestaurantes': (BuildContext context) => new ListarRestaurantes(),
          '/presentation/pages/listarPlatos':(BuildContext context)=> new ListarPlatos(),
          
      },
    );
  }
}