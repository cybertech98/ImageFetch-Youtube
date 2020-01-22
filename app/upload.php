<?php

//hostname - username - password - database name
$conn = mysqli_connect("localhost", "root", "", "youtube");

    
if($_SERVER['REQUEST_METHOD'] == 'POST')
 {
 $DefaultId = 0;
 
 $ImageData = $_POST['image_path'];
 
 $ImageName = $_POST['item_name'];
 $ItemPrice = $_POST['item_price'];
 $ItemDesc = $_POST['item_desc'];
 $GetOldIdSQL ="SELECT item_id FROM itemuploaded ORDER BY item_id ASC";
 
 $Query = mysqli_query($conn,$GetOldIdSQL)or die(mysqli_error($conn));
 
 while($row = mysqli_fetch_array($Query,)){
 
 $DefaultId = $row['item_id'];
 }
 
 $ImagePath = "files/$DefaultId.png";
 
 $ServerURL = "http://192.168.0.107/UploadImage-YouTube/$ImagePath";
 
 $InsertSQL = "insert into itemuploaded (image_path,item_name,item_price,item_desc) values ('$ServerURL','$ImageName','$ItemPrice','$ItemDesc')";
 
 if(mysqli_query($conn, $InsertSQL)){

 file_put_contents($ImagePath,base64_decode($ImageData));

 echo "Your Image Has Been Uploaded.";
 }
 
 mysqli_close($conn);
 }else{
 echo "Not Uploaded";
 }
 ?>