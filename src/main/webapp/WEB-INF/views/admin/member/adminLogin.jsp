<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="../common/header.jsp"%>

<body class="bg-gradient-primary">
<div class="container">

    <!-- Outer Row -->
    <div class="row justify-content-center">

        <div class="col-xl-10 col-lg-12 col-md-9">

            <div class="card o-hidden border-0 shadow-lg my-5">
                <div class="card-body p-0">
                    <!-- Nested Row within Card Body -->
                    <div class="row">
                        <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
                        <div class="col-lg-6">
                            <div class="p-5">
                                <div class="text-center">
                                    <h1 class="h4 text-gray-900 mb-4">Admin</h1>
                                </div>

                                <form class="user" method="post" action="admin_login">
                                    <div class="form-group">
                                        <input type="text" class="form-control form-control-user"
                                               id="id" name="id" placeholder="Enter ID">
                                    </div>
                                    <div class="form-group">
                                        <input type="password" class="form-control form-control-user"
                                               id="pwd" name="pwd" placeholder="Password">
                                    </div>
<%--                                    <label>${message }</label>--%>
                                    <input type="submit" class="btn btn-primary btn-user btn-block" value="Login">
                                </form>

                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>

    </div>

</div>

<%@ include file="../common/footer.jsp"%>

<%--</body>--%>
<%--</html>--%>