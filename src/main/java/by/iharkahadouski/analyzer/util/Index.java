package by.iharkahadouski.analyzer.util;

import java.util.Objects;

public class Index {
	private Long id;
	private IssueType issueType;
	private String message;

	public Index() {
	}

	public Index(Long id, IssueType issueType, String message) {
		this.id = id;
		this.issueType = issueType;
		this.message = message;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public IssueType getIssueType() {
		return issueType;
	}

	public void setIssueType(IssueType issueType) {
		this.issueType = issueType;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Index{" + "id=" + id + ", issueType=" + issueType + ", message='" + message + '\'' + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Index index = (Index) o;
		return Objects.equals(id, index.id) && issueType == index.issueType && Objects.equals(message, index.message);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, issueType, message);
	}
}
