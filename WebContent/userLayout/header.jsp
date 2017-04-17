<header class="header white-bg">
              <div class="sidebar-toggle-box">
                  <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
              </div>
            <!--logo start-->
            <!-- <a href="" class="logo"> --><span style="position: absolute;top:10px"><img src="img/logo.png" height="40px"></img></span><!--  </a> -->
            <!--logo end-->
            <div class="nav notify-row" id="top_menu">
             
            </div>
            <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
            <div class="top-nav ">
                <!--search & user info start-->
                <ul class="nav pull-right top-menu">
                    <!-- <li>
                        <input type="text" class="form-control search" placeholder="Search">
                    </li> -->
                    <!-- user login dropdown start-->
                    <li class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                           
                            <span class="username"><%out.print((String)session.getAttribute("userName")); %></span>
                            <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu extended logout">
                            <div class="log-arrow-up"></div>
                            
                            <c:if test="${sessionScope.usertype eq 'registereedUser' }">
                            
                            <li><a href="${pageContext.request.contextPath}/RegisterUserController?flag=searchRegisterUser"><i class=" fa fa-suitcase"></i>Profile</a></li>
                            </c:if>
                            <c:if test="${sessionScope.usertype eq 'developer' }">
                            
                            <li><a href="${pageContext.request.contextPath}/RegisterDeveloperController?flag=searchEditDeveloper"><i class=" fa fa-suitcase"></i>Profile</a></li>
                            </c:if>
                            <c:if test="${sessionScope.usertype eq 'company' }">
                            
                            <li><a href="${pageContext.request.contextPath}/RegisterCompanyController?flag=searchEditCompany"><i class=" fa fa-suitcase"></i>Profile</a></li>
                            </c:if>
                            
                            <li><a href="asd?flag=logout"><i class="fa fa-key"></i> Log Out</a></li>
                        </ul>
                    </li>
                    
                    <!-- user login dropdown end -->
                </ul>
                <!--search & user info end-->
            </div>
        </header>