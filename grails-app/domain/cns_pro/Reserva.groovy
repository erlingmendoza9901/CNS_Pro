package cns_pro

import java.sql.Time
import java.time.LocalDateTime

class Reserva {
    String code_reservation
    LocalDateTime fecha_reservation
    Time hora
    String client_code
    static constraints = {
    }
}
