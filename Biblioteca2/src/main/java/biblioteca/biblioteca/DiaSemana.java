package biblioteca;

public enum DiaSemana {
        LUNES("08:00", "15:00"),
        MARTES("08:00", "15:00"),
        MIERCOLES("08:00", "15:00"),
        JUEVES("08:00", "15:00"),
        VIERNES("08:00", "15:00"),
		SABADO("08:00", "15:00");

        private final String horaApertura;
        private final String horaCierre;

        DiaSemana(String horaApertura, String horaCierre) {
            this.horaApertura = horaApertura;
            this.horaCierre = horaCierre;
        }

        public String getHoraApertura() {
            return horaApertura;
        }

        public String getHoraCierre() {
            return horaCierre;
        }

		
    
}
