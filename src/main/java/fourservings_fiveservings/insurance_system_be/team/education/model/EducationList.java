package fourservings_fiveservings.insurance_system_be.team.education.model;


/**
 * @author kosun
 * @version 1.0

 */
public interface EducationList {

	void add(Education education);

	void delete(Education education);

	Education read(int educationId);

	void update(Education education);

}