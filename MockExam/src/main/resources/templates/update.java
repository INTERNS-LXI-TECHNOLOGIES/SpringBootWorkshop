<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="ISO-8859-1">
    <title>MockExam Management System</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h1>MockExam Management System</h1>
        <hr>
        <h2>Update Question</h2>

        <form action="#" th:action="@{/saveQuestion}" th:object="${question}" method="POST">
            <!-- Add hidden form field to handle update -->
            <input type="hidden" th:field="*{id}" />

            <input type="text" th:field="*{question}" class="form-control mb-4 col-4">

            <input type="text" th:field="*{answer}" class="form-control mb-4 col-4">

            <input type="text" th:field="*{option1}" class="form-control mb-4 col-4">

             <input type="text" th:field="*{option2}" class="form-control mb-4 col-4">

              <input type="text" th:field="*{option3}" class="form-control mb-4 col-4">

            <button type="submit" class="btn btn-info col-2"> Update quetion</button>
        </form>

        <hr>
        <a th:href="@{/}"> Back</a>
    </div>
</body>
</html>

