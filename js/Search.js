function updatePrice(ID) {
    var itemid = document.getElementById(ID).name;
    var quantity = document.getElementById(ID).value;
    createXMLHttpRequest();
    xmlHttpRequest.open("GET","updateUseAjaxServlet?itemid="+itemid+"&quantity="+quantity,true);
    xmlHttpRequest.onreadystatechange = processResponse1;
    xmlHttpRequest.send(null);
}

function processResponse1() {
    if (xmlHttpRequest.readyState == 4){
        if (xmlHttpRequest.status == 200){
            var total = xmlHttpRequest.responseXML.getElementsByTagName('tid');
            var subtotal = xmlHttpRequest.responseXML.getElementsByTagName('name');
            var item = xmlHttpRequest.responseXML.getElementsByTagName('item')[0].firstChild.nodeValue;
            alert(total[0].firstChild.nodeValue);

            var a = document.getElementById(item+"total");
            a.innerHTML = "$"+total[0].firstChild.nodeValue;

            var b = document.getElementById('Subtotal');
            b.innerHTML = "Sub Total:$"+subtotal[0].firstChild.nodeValue+"<input type='submit' value='UpdateCart' id='update'/>"
        }
    }
}