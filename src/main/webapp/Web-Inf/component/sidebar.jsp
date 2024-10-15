<div class="sidebar" data-background-color="dark">
        <div class="sidebar-logo">
          <!-- Logo Header -->
          <div class="logo-header" data-background-color="dark">
            <a href="/dashboard" class="logo">
              <span class="navbar-brand text-white h1">SMS</span>
            </a>
            <div class="nav-toggle">
              <button class="btn btn-toggle toggle-sidebar">
                <i class="gg-menu-right"></i>
              </button>
              <button class="btn btn-toggle sidenav-toggler">
                <i class="gg-menu-left"></i>
              </button>
            </div>
            <button class="topbar-toggler more">
              <i class="gg-more-vertical-alt"></i>
            </button>
          </div>
          <!-- End Logo Header -->
        </div>
        <div class="sidebar-wrapper scrollbar scrollbar-inner">
          <div class="sidebar-content">
            <ul class="nav nav-secondary">
              <li class="nav-item active">
                <a
                  data-bs-toggle="collapse"
                  href="#dashboard"
                  class="collapsed"
                  aria-expanded="false"
                >
                  <i class="fas fa-home"></i>
                  <p>Dashboard</p>
                  <span class="caret"></span>
                </a>
                <div class="collapse" id="dashboard">
                  <ul class="nav nav-collapse">
                    <li>
                      <a href="/dashboard">
                        <span class="sub-item">Dashboard 1</span>
                      </a>
                    </li>
                  </ul>
                </div>
              </li>
              <li class="nav-section">
                <span class="sidebar-mini-icon">
                  <i class="fa fa-ellipsis-h"></i>
                </span>
                <h4 class="text-section">Admin</h4>
              </li>
              <li class="nav-item ${StudentActiveSubMenu}">
                <a data-bs-toggle="collapse" href="#base">
                 <i class="fa-solid fa-users"></i>
                  <p>Student</p>
                  <span class="caret"></span>
                </a>
                
                <div class="collapse ${StudentShow}" id="base">
                  <ul class="nav nav-collapse">
                    <li class="${StudentListActive}">
                      <a href="/studentList">
                        <span class="sub-item">Student List</span>
                      </a>
                    </li>
                    <li class="${AddStudentActive}">
                      <a href="/addstudent">
                        <span class="sub-item">Add Student</span>
                      </a>
                    </li>
                  
                  </ul>
                </div>
              </li>
              <li class="nav-item ${AdminActiveSubMenu}">
                <a data-bs-toggle="collapse" href="#sidebarLayouts">
                  <i class="fa-solid fa-user"></i>
                  <p>Admin</p>
                  <span class="caret"></span>
                </a>
                <div class="collapse ${AdminShow}" id="sidebarLayouts">
                  <ul class="nav nav-collapse">
                    <li class="${AdminListActive}">
                      <a href="/adminList">
                        <span class="sub-item">Admin List</span>
                      </a>
                    </li>
                    <li class="${AddAdminActive}">
                      <a href="/addAdmin">
                        <span class="sub-item">Add Admin</span>
                      </a>
                    </li>
                  </ul>
                </div>
              </li>
              
            </ul>
          </div>
        </div>
      </div>