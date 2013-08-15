<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${empty usuarioLogado}">
    <c:redirect url="../" />
</c:if>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>ASSTEC Ortus</title>
    <link href="../css/stylesTemplate.css" rel="stylesheet" type="text/css">
    <script src="../js/templateJS.js" type="text/javascript" charset="utf-8"></script>
    
    <script language="JavaScript" src="../js/jquery-1.8.2.js" type="text/javascript"></script>



        <link href="../css/demo_table_jui.css" rel="stylesheet" type="text/css" media="screen" />
        <link href="../css/themes/smoothness/jquery-ui-1.8.4.custom.css" rel="stylesheet" type="text/css" media="screen" />

        <link href="../css/style.listar.css" rel="stylesheet" type="text/css" media="screen" />

        <script type="text/javascript" language="javascript" src="../js/jquery.dataTables.js"></script>
        <script type="text/javascript" charset="utf-8">
            var oTable;
			
            $(document).ready(function() {
                $('#form_listagem').submit( function() {
                    var sData = oTable.$('input').serialize();
                    alert( "\n\n"+sData );
                    return false;
                } );
				
                oTable = $('#listagem').dataTable({
                                        
                    "bJQueryUI": true,
                    "sPaginationType": "full_numbers","oLanguage": {
                        "sUrl": "../css/themes/de_DE.txt"
                                        
                    }
                });
            } );
                                
        </script>
</head>



