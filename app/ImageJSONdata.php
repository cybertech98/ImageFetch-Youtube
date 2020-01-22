<?php

$conn = mysqli_connect("localhost","root" , "", "youtube");

if ($conn->connect_error) {
 die("Connection failed: " . $conn->connect_error);
} 

$sql = "SELECT * FROM itemuploaded";
$result = $conn->query($sql);

if ($result->num_rows >0) {
 while($row[] = $result->fetch_assoc()) {
 
 $tem = $row;
 
 $json = json_encode($tem);
 
 
 }
 
} else {
 echo "0 results";
}
 echo $json;
$conn->close();
?>