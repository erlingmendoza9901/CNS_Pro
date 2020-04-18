package cns_pro

import grails.gorm.services.Service

@Service(Detail_Reservation)
interface Detail_ReservationService {

    Detail_Reservation get(Serializable id)

    List<Detail_Reservation> list(Map args)

    Long count()

    void delete(Serializable id)

    Detail_Reservation save(Detail_Reservation detail_Reservation)

}