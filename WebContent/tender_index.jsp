<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>BEP工程项目招标平台（招标方端）</title>
</head>
<style>
    body {
        margin: 0;
        padding: 0;
        height: 100%;
    }

    #header {
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;
        height: 60px;
    }

    #left {
        position: fixed;
        top: 60px;
        width: 210px;
        height: 100%;
    }

    #right {
        position: fixed;
        left: 200px;
        top: 60px;
        height: calc(100% - 60px);
        width: calc(100% - 210px);
    }
</style>

<body>
    <div>
        <iframe id="header" width="100%" src="page_header.jsp" style="border: 0px;"></iframe>
    </div>
    <div>
        <iframe id="left" src="tender_left.jsp" style="border: 0px;"></iframe>
        <iframe id="right" src="tender_right.jsp" name="main" style="border: 0px;"></iframe>
    </div>
</body>

</html>