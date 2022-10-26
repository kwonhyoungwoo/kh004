<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%--<fmt:requestEncoding value="UTF-8" />--%>

<%@ include file="common/header.jsp"%>
<style>
#board-container {width: 70%; margin: 0 auto; padding-top: 3%;}
#notice1 {width :35%; height: 300px; margin: 0 auto; paddtin-top: 3%; }
#notice2 {width :35%; height: 300px; margin: 0 auto; paddtin-top: 3%; }
</style>
<div class="container-fluid" id="board-container">

    <!-- Content Row -->
    <div class="row">

        <!-- Earnings (Monthly) Card Example -->
        <div class="col-xl-3 col-md-6 mb-4">
            <div class="card border-left-primary shadow h-100 py-2">
                <div class="card-body">
                    <div class="row no-gutters align-items-center">
                        <div class="col mr-2">
                            <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">


                                월간 수입</div>
                            <div class="h5 mb-0 font-weight-bold text-gray-800">57,700,000원</div>
                        </div>


                        <div class="col-auto">
                            <i class="fas fa-calendar fa-2x text-gray-300"></i>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Earnings (Monthly) Card Example -->
        <div class="col-xl-3 col-md-6 mb-4">
            <div class="card border-left-success shadow h-100 py-2">
                <div class="card-body">
                    <div class="row no-gutters align-items-center">
                        <div class="col mr-2">
                            <div class="text-xs font-weight-bold text-success text-uppercase mb-1">


                                연간 수입</div>
                            <div class="h5 mb-0 font-weight-bold text-gray-800">306,000,000원</div>
                        </div>


                        <div class="col-auto">
                            <i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Earnings (Monthly) Card Example -->
        <div class="col-xl-3 col-md-6 mb-4">
            <div class="card border-left-info shadow h-100 py-2">
                <div class="card-body">
                    <div class="row no-gutters align-items-center">
                        <div class="col mr-2">


                            <div class="text-xs font-weight-bold text-info text-uppercase mb-1">작업
                            </div>


                            <div class="row no-gutters align-items-center">
                                <div class="col-auto">
                                    <div class="h5 mb-0 mr-3 font-weight-bold text-gray-800">50%</div>
                                </div>
                                <div class="col">
                                    <div class="progress progress-sm mr-2">
                                        <div class="progress-bar bg-info" role="progressbar"
                                             style="width: 50%" aria-valuenow="50" aria-valuemin="0"
                                             aria-valuemax="100"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-auto">
                            <i class="fas fa-clipboard-list fa-2x text-gray-300"></i>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Pending Requests Card Example -->
        <div class="col-xl-3 col-md-6 mb-4">
            <div class="card border-left-warning shadow h-100 py-2">
                <div class="card-body">
                    <div class="row no-gutters align-items-center">
                        <div class="col mr-2">


                            <div class="text-xs font-weight-bold text-warning text-uppercase mb-1">
                                보류 중인 요청</div>
                            <div class="h5 mb-0 font-weight-bold text-gray-800">18</div>
                        </div>


                        <div class="col-auto">
                            <i class="fas fa-comments fa-2x text-gray-300"></i>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Content Row -->

    <div class="row">

        <!-- Area Chart -->
        <div class="col-xl-6 col-lg-7" id="notice1">
            <div class="card shadow mb-4">
                <!-- Card Header - Dropdown -->
                <div
                        class="card-header py-3 d-flex flex-row align-items-center justify-content-between">


                    <h6 class="m-0 font-weight-bold text-primary">수입 개요</h6>


<%--                    <div class="dropdown no-arrow">--%>
<%--                        <a class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink"--%>
<%--                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">--%>
<%--                            <i class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>--%>
<%--                        </a>--%>

<%--                        <div class="dropdown-menu dropdown-menu-right shadow animated--fade-in"--%>
<%--                             aria-labelledby="dropdownMenuLink">--%>
<%--                            <div class="dropdown-header">Dropdown Header:</div>--%>
<%--                            <a class="dropdown-item" href="#">Action</a>--%>
<%--                            <a class="dropdown-item" href="#">Another action</a>--%>
<%--                            <div class="dropdown-divider"></div>--%>
<%--                            <a class="dropdown-item" href="#">Something else here</a>--%>
<%--                        </div>--%>
<%--                    </div>--%>
                </div>
                <!-- Card Body -->
                <div class="card-body">
                    <div class="chart-area">
                        <canvas id="myAreaChart"></canvas>
                    </div>
                </div>
            </div>
        </div>

        <!-- Pie Chart -->
        <div class="col-xl-6 col-lg-7" id="notice2">
            <div class="card shadow mb-4">
                <!-- Card Header - Dropdown -->
                <div
                        class="card-header py-3 d-flex flex-row align-items-center justify-content-between">


                    <h6 class="m-0 font-weight-bold text-primary">수익원</h6>


<%--                    <div class="dropdown no-arrow">--%>
<%--                        <a class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink"--%>
<%--                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">--%>
<%--                            <i class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>--%>
<%--                        </a>--%>
<%--                        <div class="dropdown-menu dropdown-menu-right shadow animated--fade-in"--%>
<%--                             aria-labelledby="dropdownMenuLink">--%>
<%--                            <div class="dropdown-header">Dropdown Header:</div>--%>
<%--                            <a class="dropdown-item" href="#">Action</a>--%>
<%--                            <a class="dropdown-item" href="#">Another action</a>--%>
<%--                            <div class="dropdown-divider"></div>--%>
<%--                            <a class="dropdown-item" href="#">Something else here</a>--%>
<%--                        </div>--%>
<%--                    </div>--%>
                </div>
                <!-- Card Body -->
                <div class="card-body">
                    <div class="chart-pie pt-4 pb-4">
                        <canvas id="myPieChart"></canvas>
                    </div>
<%--                    <div class="mt-4 text-center small">--%>
<%--                                        <span class="mr-2">--%>
<%--                                            <i class="fas fa-circle text-primary"></i> Direct--%>
<%--                                        </span>--%>
<%--                        <span class="mr-2">--%>
<%--                                            <i class="fas fa-circle text-success"></i> Social--%>
<%--                                        </span>--%>
<%--                        <span class="mr-2">--%>
<%--                                            <i class="fas fa-circle text-info"></i> Referral--%>
<%--                                        </span>--%>
<%--                    </div>--%>
                </div>
            </div>
        </div>
    </div>

    <!-- Content Row -->
    <div class="row">

        <!-- Content Column -->
        <div class="col-lg-6 mb-4">

            <!-- Project Card Example -->
            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">현재 상황</h6>
                </div>

                <div class="card-body">
                    <h4 class="small font-weight-bold">서버 이동률 <span
                            class="float-right">20%</span></h4>

                    <div class="progress mb-4">
                        <div class="progress-bar bg-danger" role="progressbar" style="width: 20%"
                             aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"></div>
                    </div>

                    <h4 class="small font-weight-bold">판매 추적 <span
                            class="float-right">40%</span></h4>
                    <div class="progress mb-4">
                        <div class="progress-bar bg-warning" role="progressbar" style="width: 40%"
                             aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"></div>
                    </div>

                    <h4 class="small font-weight-bold">고객 데이터 상황 <span
                            class="float-right">60%</span></h4>
                    <div class="progress mb-4">
                        <div class="progress-bar" role="progressbar" style="width: 60%"
                             aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"></div>
                    </div>

                    <h4 class="small font-weight-bold">지불 방법 <span
                            class="float-right">80%</span></h4>
                    <div class="progress mb-4">
                        <div class="progress-bar bg-info" role="progressbar" style="width: 80%"
                             aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"></div>
                    </div>

                    <h4 class="small font-weight-bold">결제 상황 <span
                            class="float-right">Complete!</span></h4>

                    <div class="progress">
                        <div class="progress-bar bg-success" role="progressbar" style="width: 100%"
                             aria-valuenow="100" aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                </div>
            </div>

<%--            <!-- Color System -->--%>
<%--            <div class="row">--%>
<%--                <div class="col-lg-6 mb-4">--%>
<%--                    <div class="card bg-primary text-white shadow">--%>
<%--                        <div class="card-body">--%>
<%--                            Primary--%>
<%--                            <div class="text-white-50 small">#4e73df</div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="col-lg-6 mb-4">--%>
<%--                    <div class="card bg-success text-white shadow">--%>
<%--                        <div class="card-body">--%>
<%--                            Success--%>
<%--                            <div class="text-white-50 small">#1cc88a</div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="col-lg-6 mb-4">--%>
<%--                    <div class="card bg-info text-white shadow">--%>
<%--                        <div class="card-body">--%>
<%--                            Info--%>
<%--                            <div class="text-white-50 small">#36b9cc</div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="col-lg-6 mb-4">--%>
<%--                    <div class="card bg-warning text-white shadow">--%>
<%--                        <div class="card-body">--%>
<%--                            Warning--%>
<%--                            <div class="text-white-50 small">#f6c23e</div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="col-lg-6 mb-4">--%>
<%--                    <div class="card bg-danger text-white shadow">--%>
<%--                        <div class="card-body">--%>
<%--                            Danger--%>
<%--                            <div class="text-white-50 small">#e74a3b</div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="col-lg-6 mb-4">--%>
<%--                    <div class="card bg-secondary text-white shadow">--%>
<%--                        <div class="card-body">--%>
<%--                            Secondary--%>
<%--                            <div class="text-white-50 small">#858796</div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="col-lg-6 mb-4">--%>
<%--                    <div class="card bg-light text-black shadow">--%>
<%--                        <div class="card-body">--%>
<%--                            Light--%>
<%--                            <div class="text-black-50 small">#f8f9fc</div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="col-lg-6 mb-4">--%>
<%--                    <div class="card bg-dark text-white shadow">--%>
<%--                        <div class="card-body">--%>
<%--                            Dark--%>
<%--                            <div class="text-white-50 small">#5a5c69</div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>

        <div class="col-lg-6 mb-4">

            <!-- Illustrations -->
            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">아 무 거 나</h6>
                </div>

                <div class="card-body">
                    <div class="text-center">
                        <img class="img-fluid px-3 px-sm-4 mt-3 mb-4" style="width: 100rem;"
                             src="img/undraw_posting_photo.svg" alt="...">
                    </div>
                    <p> 아 무 거 나ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏ
                        <a target="_blank" rel="nofollow" href="https://">들어감</a>
                        텍스트텍스트텍스트텍스트텍스트텍스트텍스트텍스트텍스트텍스트텍스트텍스트
                        텍스트텍스트텍스트텍스트텍스트텍스트텍스트텍스트텍스트텍스트텍스트텍스트
                    </p>
                    <a target="_blank" rel="nofollow" href="https://undraw.co/">어디로가누 &rarr;</a>
                </div>
            </div>

            <!-- Approach -->
            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">텍스트텍스트텍스트텍스트</h6>
                </div>
                <div class="card-body">
                    <p>텍스트텍스트텍스트텍스트텍스트텍스트텍스트텍스트텍스트
                        텍스트텍스트텍스트텍스트텍스트텍스트텍스트텍스트</p>
                    <p class="mb-0">텍스트텍스트텍스트텍스트텍스트텍스트텍스트텍스트텍스트
                        텍스트텍스트텍스트텍스트텍스트텍스트텍스트텍스트텍스트텍스트</p>
                </div>
            </div>

        </div>
    </div>

</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->


<%@ include file="common/footer.jsp"%>