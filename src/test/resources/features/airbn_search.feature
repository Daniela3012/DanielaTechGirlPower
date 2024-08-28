Feature: Búsqueda en Airbnb

  @test
  Scenario: Búsqueda simple de hospedaje

    Given estoy en la pantalla de login de Airbnb
    When busco mi preferencia "Cancun Mexico"
    Then muestra el resultado "Over 1,000 stays"