import 'package:flutter/material.dart';

void main() =>runApp(MaterialApp(
  home:Scaffold(
    body:Container(
      color:Colors.white,
      padding: EdgeInsets.symmetric(horizontal: 40,vertical: 80),
      width:500,
      height:500,
      child:CustomPaint(painter:Grapes()),
    )
    
    
    ) ,
  ),
  );

  class Grapes extends CustomPainter{
    @override
    void paint(Canvas canvas,Size size)
    {
          final paint=Paint()
          ..style=PaintingStyle.fill
          ..strokeWidth=4.0
          ..color=Colors.purple;

          final paint1=Paint()
          ..style=PaintingStyle.fill
          ..strokeWidth=5.0
          ..color=Colors.green;

           canvas.drawLine(Offset(160,40), Offset(160,1), paint1);
           canvas.drawOval(
              Rect.fromLTWH(30, 20, 70, 100),
              paint,
       );
        canvas.drawOval(
              Rect.fromLTWH(90, 20, 70, 100),
              paint,
       );
         canvas.drawOval(
              Rect.fromLTWH(150, 20, 70, 100),
              paint,
       );
        canvas.drawOval(
              Rect.fromLTWH(210, 20, 70, 100),
              paint,
       );
        canvas.drawOval(
              Rect.fromLTWH(50, 100, 70, 100),
              paint,
       );
       canvas.drawOval(
              Rect.fromLTWH(110, 100, 70, 100),
              paint,
       );
       canvas.drawOval(
              Rect.fromLTWH(170, 100, 70, 100),
              paint,
       );
       canvas.drawOval(
              Rect.fromLTWH(170, 100, 70, 100),
              paint,
       );
        canvas.drawOval(
              Rect.fromLTWH(80, 160, 70, 100),
              paint,
       );
       canvas.drawOval(
              Rect.fromLTWH(150, 160, 70, 100),
              paint,
       );
       canvas.drawOval(
              Rect.fromLTWH(120, 220, 70, 100),
              paint,
       );
    }
    @override
    bool shouldRepaint(Grapes oldDelegate)=>false;

  }

