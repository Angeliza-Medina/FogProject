<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Fog - CCPI Liste</title>

    <link rel="icon" type="image/png" href="../assets/images/logo/favicon.jpg"/>

    <!-- CSS -->
    <link rel="stylesheet" href="../assets/css/base.css">
    <link rel="stylesheet" href="../assets/css/admin_header.css">
    <link rel="stylesheet" href="../assets/css/ccpiList.css">
    <link rel="stylesheet" href="../assets/css/admin_footer.css">

    <!-- Fonts -->
    <script src="https://kit.fontawesome.com/ca25e16baf.js" crossorigin="anonymous"></script>
</head>

<body>
<div id="wrapper">
    <header>
        <div id="header_container" class="flexRow">
            <div id="logo_container" class="posRelative">
                <img src="assets/images/logo/logo.png" alt="Johannes Fog logo">
                <a id="logo_link" href="index.html"></a>
            </div>

            <div id="headerNav_container" class="flexColumn">
                <div id="headerNavTop_container" class="flexRow">
                    <div id="logout_container" class="flexRow">
                        <div id="logoutLink_container">
                            <a id="logout_link" href="index.html">
                                <i class="fas fa-user-circle"></i>
                                Log ud
                            </a>
                        </div>

                        <div id="email_container">
                            admin@gmail.com
                        </div>
                    </div> <!-- #logout_container .flexRow END -->

                    <div id="topNav_container" class="flexRow">
                        <div class="topNavLink_container">
                            <a href="" class="header_link topNav_link">Outlet</a>
                        </div>

                        <div class="topNavLink_container">
                            <a href="" class="header_link topNav_link">Bolig & Designhus</a>
                        </div>

                        <div class="topNavLink_container">
                            <a href="" class="header_link topNav_link">Trælast & Byggecenter</a>
                        </div>

                        <div class="topNavLink_container">
                            <a href="" class="header_link topNav_link">FogPro</a>
                        </div>
                    </div>
                </div> <!-- #headerNavTop_container .flexRow END -->

                <div id="headerNavBtm_container" class="flexRow">
                    <section id="navBtm_section" class="flexRow">
                        <div class="btmNavLink_container">
                            <a href="" class="header_link">
                                Behandl carport forespørgsler
                            </a>
                        </div>

                        <div class="btmNavLink_container">
                            <a href="" class="header_link">
                                Rediger produkter
                            </a>
                        </div>
                </div> <!-- #headerNavBtm_container .flexRow END -->
            </div> <!-- #headerNav_container .flexColumn END -->
        </div>
    </header>

    <main>
        <div id="pageHeadline_container">
            <h2>Carport forespørgsler</h2>
        </div>

        <div id="search_container">
            <form action="" method="GET" id="search_form" class="flexRow">
                <div id="searchInput_container">
                    <input name="search_input" type="text" id="search_input">
                </div>

                <div id="searchBtn_container">
                    <button type="submit" id="searchBtn">
                        <i class="fas fa-search"></i>
                    </button>
                </div>

                <div id="searchCategory_container">
                    <select name="searchCategory" id="searchCategory_select">
                        <option value="ccpiId" selected>Forespørgsels id</option>
                        <option value="date">Dato</option>
                        <option value="lastName">Efternavn</option>
                    </select>
                </div>
            </form> <!-- #searchCCPI_form .flexRow END -->
        </div> <!-- #searchCCPI_container END -->


        <div id="filterBtns_container" class="flexRow">
            <form action="" method="GET" class="filterBtn_container">
                <input name="filterType" type="hidden" value="all">

                <button type="submit" id="allFilter" class="filterBtn">
                    Alle
                </button>
            </form>

            <form action="" method="GET" class="filterBtn_container">
                <input name="filterType" type="hidden" value="pending">

                <button type="submit" id="pendingFilter" class="filterBtn">
                    Afventer
                    <i class="fas fa-clock filterBtn_icon"></i>
                </button>
            </form>

            <form action="" method="GET" class="filterBtn_container">
                <input name="filterType" type="hidden" value="inProgress">

                <button type="submit" id="inProgressFilter" class="filterBtn">
                    Behandles
                    <i class="fas fa-hammer filterBtn_icon"></i>
                </button>
            </form>

            <form action="" method="GET" class="filterBtn_container">
                <input name="filterType" type="hidden" value="completed">

                <button type="submit" id="completedFilter" class="filterBtn">
                    Afsluttet
                    <i class="far fa-check-circle filterBtn_icon"></i>
                </button>
            </form>

            <form action="" method="GET" class="filterBtn_container">
                <input name="filterType" type="hidden" value="cancelled">

                <button type="submit" id="cancelledFilter" class="filterBtn">
                    Annulleret
                    <i class="far fa-times-circle filterBtn_icon"></i>
                </button>
            </form>
        </div> <!-- #filterLinks_container .flex -->

        <div id="ccpiList_container">
            <table id="ccpi_Table">
                <tr id="ccpiTable_head">
                    <th>Dato</th>

                    <th>Forespørgsels-id</th>

                    <th>Carport + Redskabsrum mål</th>

                    <th>Status</th>
                </tr>

                <tr class="ccpiTable_data posRelative">
                    <td>02-12-2021</td>
                    <td>#005</td>
                    <td>
                        Carport: 210 x 300 x 270<br>
                        Redskabsrum: 160 x 210
                    </td>
                    <td>
                        <i class="fas fa-clock ccpiList_icon"></i>

                        <form action="" method="GET">
                            <input type="hidden" value="1"> <!-- Change value to ccpi id -->

                            <button class="calculateCCPIBtn posAbsolute" type="submit">
                            </button>
                        </form>
                    </td>
                </tr>

                <tr class="ccpiTable_data posRelative">
                    <td>02-12-2021</td>
                    <td>#005</td>
                    <td>
                        Carport: 210 x 300 x 270
                    </td>
                    <td>
                        <i class="fas fa-hammer ccpiList_icon"></i>

                        <form action="" method="GET">
                            <input type="hidden" value="1"> <!-- Change value to ccpi id -->

                            <button class="calculateCCPIBtn posAbsolute" type="submit">
                            </button>
                        </form>
                    </td>
                </tr>

                <tr class="ccpiTable_data posRelative">
                    <td>02-12-2021</td>
                    <td>#005</td>
                    <td>
                        Carport: 210 x 300 x 270<br>
                        Redskabsrum: 160 x 210
                    </td>
                    <td>
                        <i class="far fa-check-circle ccpiList_icon"></i>

                        <form action="" method="GET">
                            <input type="hidden" value="1"> <!-- Change value to ccpi id -->

                            <button class="calculateCCPIBtn posAbsolute" type="submit">
                            </button>
                        </form>
                    </td>
                </tr>

                <tr class="ccpiTable_data posRelative">
                    <td>02-12-2021</td>
                    <td>#005</td>
                    <td>
                        Carport: 210 x 300 x 270
                    </td>
                    <td>
                        <i class="far fa-times-circle ccpiList_icon"></i>

                        <form action="" method="GET">
                            <input type="hidden" value="1"> <!-- Change value to ccpi id -->

                            <button class="calculateCCPIBtn posAbsolute" type="submit">
                            </button>
                        </form>
                    </td>
                </tr>
            </table>
        </div> <!-- #ccpiList_container END -->
        
    </main>



    <footer id="adminFooter" class="flexRow">
        <section id="businessInfo">
            Johannes Fog A/S - Firskovvej 20 - 2800 Lyngby - CVR-nr. 16314439
        </section>

        <section id="priceInfo">
            Alle priser er inkl. moms
        </section>
    </footer>
</div> <!-- #wrapper END -->

<script src="../assets/js/ccpiList.js"></script>
</body>
</html>
